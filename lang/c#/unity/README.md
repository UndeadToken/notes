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

