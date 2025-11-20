// Converts NeoForge 1.21.1 recipes down to Forge 1.20.1
//
// Also remember to fix the advancements manually

function fixFile(jsonContent: any) {
  if (jsonContent.type === "minecraft:stonecutting") {
    if (typeof jsonContent.result !== "string") {
      const result = jsonContent.result.id;
      jsonContent.result = result;
    }

    if (!jsonContent.count) {
      jsonContent.count = 1;
    }
  } else if (
    (jsonContent.type === "create:item_application" ||
      jsonContent.type === "create:deploying" ||
      jsonContent.type === "create:splashing") &&
    typeof jsonContent.results[0].item !== "string"
  ) {
    const results: any[] = jsonContent.results;

    const newResults = results.map((v) => {
      // Failsafe for unrecognized recipes
      if (!v.item.id) return v;
      return { item: v.item.id };
    });

    if (newResults) jsonContent.results = newResults;
  }

  // Convert NeoForge conditions to Forge conditions
  const conditions = jsonContent["neoforge:conditions"];
  if (conditions) {
    delete jsonContent["neoforge:conditions"];

    for (const condition of conditions) {
      condition.type = condition.type.replace("neoforge", "forge");
    }

    jsonContent.conditions = conditions;
  }

  return jsonContent;
}

async function readDirectory(path: string) {
  const content = Deno.readDir(path);

  for await (const element of content) {
    const filePath = path + "/" + element.name;

    if (element.isDirectory) readDirectory(filePath);

    if (!element.isFile) continue;
    if (!element.name.endsWith(".json")) continue;

    try {
      const fileContent = await Deno.readTextFile(filePath);
      const jsonContent = JSON.parse(fileContent);

      const newJsonContent = fixFile(Object.assign({}, jsonContent));

      const stringifiedJsonContent = JSON.stringify(newJsonContent, null, 2)
        .replaceAll('"id":', '"item":')
        .replaceAll("c:glass_blocks", "forge:glass")
        .replaceAll("c:strings", "forge:string")
        .replaceAll("c:", "forge:");
      // console.log(newJsonContent);
      // console.log(jsonContent);
      // console.log(
      //   stringifiedJsonContent === JSON.stringify(jsonContent)
      // );

      if (stringifiedJsonContent === JSON.stringify(jsonContent)) continue;

      await Deno.writeTextFile(filePath, stringifiedJsonContent);

      console.log("Written " + element.name);
    } catch {
      continue;
    }
  }
}

readDirectory(".");
