# DopeAPI
A simple Minecraft Paper API

## Things i used:

<a href="https://github.com/DV8FromTheWorld/JDA">JDA: Discord Java API</a>

<a href="https://gist.github.com/DevSrSouza/aa2f39fb2299dfe72b49b52fa46d9a73">Bukkit ItemStack Parser</a>



## Server Admins:
#### If a Minecraft Plugin Depends on this plugin you'll need to add it to you Minecraft Server by simply Download it and move it in the plugins folder.



## Developers:
What can this thing do:
+ **Manage Languages**
+ **Manage Configurations**
+ **Manage Regions**
+ **Manage Structures**
+ **Manage Delayed Actions**
+ **Manage Discord Bots**

### Language Manager:

```java
private LanguageManager languageManager;
private final String version = "1.0";

private String getString(String key,String message) {
    return languageManager.getString(key,message);
}

public void init() {
	this.languageManager = new LanguageManager(languageFolder);
	this.languageManager.load();
	System.out.println(getString("en","plugin.load").replace("%0%", this.version));
}
```

english.json
```json
{
"language": {
	"key": "en",
	"name": "english",
	"messages": [
      {"key":"plugin.load", "message":"plugin is loading with version %0%"},
      {"key":"plugin.unload", "message":"plugin is unloading"}
                ]
	}
}
```

<hr>

### Config Manager:

```java
private final File configFile = new File("config.json");
private final boolean load = true;
public void init() {
	DPConfig config = new DPConfig(this.configFile,load);
	config.jsonObject().add("name",new JsonPrimitive("Dave"));
	config.jsonObject().add("password",new JsonPrimitive("123456789"));
	config.jsonObject().add("element",new JsonObject());
}
```
config.json
```json
{
"name": "Dave",
"password": "123456789",
"element": {}
}
```

<hr>

### Region Manager:
```java
private RegionManager regionManager; 
private Location startingPoint;
private Location endingPoint;
private Player player;

public void init() {
	regionManager = new RegionManager();
    regionManager.addRegion(new Region(startingPoint, endingPoint));  
        // player inside region?
        if (regionManager.isInside(player.getLocation())) {  
        // do stuff  
        }
}
```

<hr>

### Structure Manager:
```java

private Structure structure;
private Region region;
private File exportFile;
private File importFile;
private Location spawnLocation;

public void init() {
	Structure structure = new Structure();  
	structure.load(region);  
	structure.exportConfig(exportFile);  
	structure.importConfig(importFile);  
	structure.spawn(spawnLocation);
	structure.unload();
}
```