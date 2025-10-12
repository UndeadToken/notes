### Unity

### GameObjects

Game objects have components.
Renderer − Responsible for rendering and making objects visible.
Collider − Define the physical collision boundaries for objects.
Rigidbody − Gives an object real-time physics properties such as weight and gravity.
Audio Source − Gives object properties to play and store sound.
Audio Listener − The component that actually “hears” audio and outputs it to the player’s speakers. By default, one exists in the main camera.
Animator − Gives an object access to the animation system.
Light − Makes the object behave as a light source, with a variety of different effects.
Mesh Filter -  components for visual representation

W for Move, E for Rotate, and R for Scale

Camera: select Main Camera in the Hierarchy window, and then use the
GameObject menu to select Align with View

Main Camera:

Projection: The camera can be set to Perspective, which offers a natural view with objects
appearing smaller as they recede, or Orthographic, which lacks depth, making all objects
appear at the same scale regardless of distance.

Field of View: Available in Perspective mode, this determines the width of the camera’s view.
A wider field of view captures more of the scene, while a narrower field of view zooms in closer.

Clipping planes: The Near and Far clipping planes determine the closest and furthest distances
from the camera at which objects are rendered. Objects outside this range are not displayed,
impacting performance and visibility.

Depth: Determines the rendering order of multiple cameras. Cameras with higher depth values
draw on top, which is useful for creating UI overlays or special effects.

Clear flags: Defines what is shown when no objects are rendered in the camera’s view. Options
include Skybox, Solid Color, and Don’t Clear, each affecting the background appearance in
the Game view.

### Transforms

Transforms have three visible properties − the position, the rotation, and the scale. Each of these have three values for the three axes.

The rotation properties define the amount of rotation (in degrees) an object is rotated about that axis with respect to the game world or the parent object.

The scale of an object defines how large it is when compared to its original or native size.

When a GameObject has a parent, it will perform all its transform changes with respect to another GameObject instead of the game world.

### Internal Assets

Scenes − These act as “levels”.
Animations − These contain data for a gameObject’s animations.
Materials − These define how lighting affects the appearance of an object.
Scripts − The code which will be written for the gameObjects.
Prefabs − These act as “blueprints” for GameObjects so they can be generated at runtime.

### Prefabs

Prefabs are like blueprints of a GameObject. Prefabs are, in a way, a copy of a GameObject that can be duplicated and put into a scene, even if it did not exist when the scene was being made; in other words, prefabs can be used to dynamically generate GameObjects.

### Logging

Debug.Log(“Space key was pressed!”);

### Sounds

public class BellSound : MonoBehaviour {
   AudioSource mySource;
   // Use this for initialization
   void Start () {
      mySource = GetComponent<AudioSource>();
}

private void OnMouseDown()
{
    mySource.Play();
}

### Buttons

Add a script to an empty object.

public class ButtonBehaviour : MonoBehaviour {
   int n;
   public void OnButtonPress(){
      n++;
      Debug.Log("Button clicked " + n + " times.");
   }
}

### Text

public Text myText;

myText.text = "Hello";

### Slider

public Slider mySlider;

mySlider.value

### Builtin Methods

Start() Called before the first frame update.

Update() Called on every frame update.

### Navigation

- Navigation and manipulation:
  Pan: Hold down the middle mouse button (MMB) and move the mouse to pan around
the Scene view.
  Zoom: Use the scroll wheel to zoom in and out of the scene. Alternatively, you can hold
down Alt (Option on Mac) + right mouse button (RMB) and move the mouse up and down.
  Orbit: To orbit around a point of interest, hold down the Alt (Option on Mac) key and the
left mouse button (LMB), then move the mouse. The view orbits around the current pivot
point, which is usually the center of the selected object.

- Object manipulation:
  Select: Click an object with the LMB to select it. You can select multiple objects by holding
down the Ctrl (Cmd on Mac) key while clicking.
  Move: With an object selected, press the W key to activate the Move tool. You can then click
and drag the object along the axes in the Scene view. Alternatively, you can use the LMB to
drag the object freely.
  Rotate: Press the E key to switch to the Rotate tool. Click and drag around the object to
rotate it along the desired axis.
  Scale: Press the R key to use the Scale tool, which allows you to resize the object by clicking
and dragging along the axes

- Viewing options:
  Focus: Press the F key while an object is selected to focus the Scene view on that object. This
centers the object in the view and adjusts the zoom level for a closer look.
  2D/3D mode: Toggle between 2D and 3D mode by clicking the 2D/3D button in the Scene
view toolbar. In 2D mode, navigation becomes constrained to the XY plane, suitable for 2D
game development.
  Perspective/Isometric view: Change between Perspective and Isometric views by clicking
the corresponding button in the Scene view toolbar. Perspective view offers a realistic depth
perception, while Isometric view removes perspective distortion, something that’s useful
for certain types of games.

- In Game:
  Ctrl + P (Cmd + P on Mac): Start or stop playing the game. This shortcut is particularly handy
as it allows you to quickly enter and exit Play Mode without having to move your mouse to
the Play button.
  
  No direct interaction: Unlike the Scene view, the Game view doesn’t support direct object
manipulation or navigation shortcuts as it intends to replicate the player’s experience.
Finally, let’s look at the mouse buttons that can be used in the Game view:


  LMB: This button interacts with the game’s UI elements or captures player input, depending
on how you’ve programmed the game – for example, clicking buttons, dragging UI sliders, or
controlling a character.
RMB and MMB: Typically, these don’t have default functions in the Game view unless specifically
programmed within the game’s input system.

- Hierarchy:

F2 (Windows)/Enter (Mac): Renames the selected GameObject. This is useful for quickly
organizing and identifying objects in your scene.

Delete/backspace: Removes the selected GameObject from the scene. Be cautious with this
shortcut to avoid accidentally deleting important objects.
Ctrl + D (Cmd + D on Mac): Duplicates the selected GameObject, creating an exact copy
within the same scene.
Finally, let’s look at the mouse buttons that can be used in the Hierarchy window:

LMB: Used for selecting objects, dragging to reorder or parent them, and double-clicking to
focus the Scene view on the selected object.

RMB: Opens the context menu, providing options to create new GameObjects and delete,
rename, or apply Prefab changes, among other actions.

- Project Window:

Now, let’s learn about the keyboard shortcuts that can be used in the Project window:

Delete/backspace: Deletes the selected asset or folder. A confirmation dialog will appear to
prevent accidental deletion.


F2 (Windows)/Enter (Mac): This lets you rename the selected asset or folder, allowing you to
keep your project organized and assets easily identifiable.
Ctrl + D (Cmd + D on Mac): Duplicates the selected asset, creating an exact copy within the
same folder.

LMB: Used for selecting and dragging assets. Clicking an asset selects it, while dragging it allows
you to reposition it within the folder hierarchy or drop it into the Scene view or Inspector window.
RMB: Opens the context menu, which provides various options, depending on the selected
asset or folder. This menu allows you to create new assets or folders, import assets, delete,
rename, and more.

- Inspector Window:

Ctrl + Z (Cmd + Z on Mac): Undoes changes made to an object’s properties in the
Inspector window.

Ctrl + Shift + Z (Cmd + Shift + Z on Mac): Redoes changes.

LMB: Used primarily for selecting and interacting with various fields and properties within
the Inspector window. Clicking on property fields allows you to edit values, toggle checkboxes,
and select options from drop-down menus. By dragging with the LMB, you can adjust values
such as sliders or color pickers.

RMB: In some contexts, clicking with the RMB in the Inspector window can open a contextual
menu, offering additional options such as resetting the value to its default or, for script
components, navigating to the script’s source.

### media

supported images: jpeg, png, and psd

supported audio: mp3, wav, and ogg

Supported 3D formats, including FBX, OBJ, and COLLADA.

### Folders Naming conventions

Scenes: Contains all your Unity scene files. You might further organize this with subfolders
such as Main, Levels, or UI for different parts of your game.

Scripts: Houses all your C# scripts. Subfolders can be used to categorize scripts by their purpose,
such as Characters, UI, Gameplay, or Utilities.
Materials: For storing material assets that are used to define the appearance of surfaces in
the game.

Textures: Contains image files that are used in materials or UI elements. Subfolders might
include UI, Environment, Characters, and so on.

Models: For 3D models that have been imported into your project. This can be further divided
into Characters, Props, Environment, and so on.

Animations: Stores animation files and controllers. Subcategories might include different
characters or types of animations, such as CharacterAnimations or UIAnimations.

Audio: Holds music and sound effect files, potentially organized into Music, SFX, Dialog, and
so on.

Prefabs: Prefabs are reusable GameObject templates, so this folder would contain all Prefabs
created for the project.

### Editor Folder

•
Editor folder:
The Editor folder is a special directory that’s used to store scripts, assets, and tools that are only
used within the Unity Editor and should not be included in the final build of the game. Unity
recognizes this folder and its subfolders globally and excludes their contents from game builds,
ensuring that development tools and editor-specific functionality don’t unnecessarily increase
the build size or affect the performance of the final game.
Assets and scripts placed in an Editor folder are ideal for enhancing the development process,
such as custom editor windows, inspector enhancements, or build automation scripts. If you
have multiple Editor folders at different locations within your Assets directory, Unity treats
them all with the same special consideration.

### Resources folder:
The Resources folder is used to store assets that need to be loaded dynamically at runtime using
the Resources.Load() method. Unity includes the entire contents of Resources folders in
the build, regardless of whether they are directly referenced by other assets in the project. This
allows developers to access assets by their path and name without needing a direct reference
in the editor, providing flexibility for loading content on demand.
However, this convenience comes with a performance cost. Since assets in Resources folders
are always included in the build, they can significantly increase the size of your game and lead
to longer loading times. It’s recommended to use the Resources system sparingly and consider
alternative strategies for asset management and loading, such as AssetBundles or the Addressable
Asset System, for more efficient runtime asset loading.

### Notes

Unity’s Addressable Asset System represents an advanced asset management practice that allows you
to load assets by address (for example, Assets/Textures/Player.png, Assets/Prefabs/
Enemy.prefab, or a remote server)

Tools such as Unity’s Asset
Usage Detector can help identify unused assets that can be safely removed or archived.

