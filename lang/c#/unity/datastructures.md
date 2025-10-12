# Datastructures

using System.Collections.Generic;
using UnityEngine;

public class InventoryManager : MonoBehaviour
{
    // Dictionary to hold item IDs and their names
    Dictionary<int, string> inventory = new Dictionary<int, string>();

    void Start()
    {
        // Adding items to the dictionary
        inventory.Add(1, "Sword");
        inventory.Add(2, "Shield");
        inventory.Add(3, "Health Potion");

        // Displaying an item name by its ID
        Debug.Log("Item with ID 1: " + inventory[1]);
    }
}

Newtonsoft.Json or Full Serializer

using UnityEngine;

[System.Serializable]
public class PlayerPreferences
{
    public float audioVolume;
    public int brightness;
    public bool subtitlesEnabled;
}

public class PreferencesManager : MonoBehaviour
{
    void Start()
    {
        PlayerPreferences prefs = new PlayerPreferences()
        {
            audioVolume = 0.8f,
            brightness = 50,
            subtitlesEnabled = true
        };

        // Serialize the PlayerPreferences object to a JSON string
        string prefsJson = JsonUtility.ToJson(prefs);
        Debug.Log("Serialized JSON: " + prefsJson);

        // Deserialize the JSON string back to a new PlayerPreferences object
        PlayerPreferences loadedPrefs = JsonUtility.FromJson<PlayerPreferences>(prefsJson);

        Debug.Log(
            "Loaded Preferences: " +
            "Audio Volume - " + loadedPrefs.audioVolume +
            ", Brightness - " + loadedPrefs.brightness +
            ", Subtitles Enabled - " + loadedPrefs.subtitlesEnabled
        );
    }
}

// Event manager class
public class CustomEventManager : MonoBehaviour
{
    // Define a simple event system
    public delegate void InputAction(string key);
    public static event InputAction OnInputReceived;

    void Update()
    {
        if (Input.GetKeyDown(KeyCode.Space))
        {
            OnInputReceived?.Invoke("Space");
        }
    }
}

// In another class
public class PlayerInputHandler : MonoBehaviour
{
    void OnEnable()
    {
        CustomEventManager.OnInputReceived += HandleSpace;
    }

    void OnDisable()
    {
        CustomEventManager.OnInputReceived -= HandleSpace;
    }

    void HandleSpace(string key)
    {
        if (key == "Space")
        {
            // Perform jump
        }
    }
}

// UIManager.cs
public class UIManager : MonoBehaviour
{
    // Event declaration
    public delegate void VolumeChange(float newVolume);
    public static event VolumeChange OnVolumeChanged;

    // Trigger the event when the slider changes
    public void VolumeSliderChanged(float volume)
    {
        OnVolumeChanged?.Invoke(volume);
    }
}

// AudioManager.cs
public class AudioManager : MonoBehaviour
{
    public AudioSource audioSource;

    void OnEnable()
    {
        UIManager.OnVolumeChanged += UpdateVolume;
    }

    void OnDisable()
    {
        UIManager.OnVolumeChanged -= UpdateVolume;
    }

    void UpdateVolume(float volume)
    {
        audioSource.volume = volume;
    }
}

// EnvironmentManager.cs
public class EnvironmentManager : MonoBehaviour
{
    // Define an event for entering a trigger zone
    public delegate void PlayerTrigger(string zoneID);
    public static event PlayerTrigger OnPlayerEnterTriggerZone;

    public string zoneID;

    void OnTriggerEnter(Collider other)
    {
        if (other.CompareTag("Player"))
        {
            OnPlayerEnterTriggerZone?.Invoke(zoneID);
        }
    }
}

// DialogueManager.cs or GameManager.cs
public class DialogueManager : MonoBehaviour
{
    void OnEnable()
    {
        EnvironmentManager.OnPlayerEnterTriggerZone += TriggerDialogue;
    }

    void OnDisable()
    {
        EnvironmentManager.OnPlayerEnterTriggerZone -= TriggerDialogue;
    }

    void TriggerDialogue(string zoneID)
    {
        if (zoneID == "StoryZone")
        {
            // Start specific dialogue
        }
    }
}

void OnEnable() {
  EventManager.OnCustomEvent += CustomEventHandler;
}

void OnDisable() {
  EventManager.OnCustomEvent -= CustomEventHandler;
}

void CustomEventHandler() {
PerformAction();
UpdateUI();
SaveData();
PlaySound();
LogEvent();
// Multiple actions directly in the event handler
}

void CustomEventHandler() {
PerformActions();
// Delegates to another method
}
void PerformActions() {
PerformAction();
UpdateUI();
SaveData();
PlaySound();
LogEvent();
}

// After optimization: Single loop
int arrayWidth = array[0].Length;
// Assuming all inner arrays have the same length
int totalElements = array.Length * arrayWidth;
for (int k = 0; k < totalElements; k++)
{
int i = k / arrayWidth; // Calculate the row index
int j = k % arrayWidth;
// Calculate the column index using modulo operation
// Perform operation
}

// Before optimization: Instantiate and destroy objects
GameObject myObject = Instantiate(prefab, position, rotation);
Destroy(gameObject);
// After optimization: Object pooling
GameObject pooledObject = GetPooledObject();
if (pooledObject != null)
{
pooledObject.SetActive(true);
pooledObject.transform.position = position;
pooledObject.transform.rotation = rotation;
}

using UnityEngine;
public class InvokeSendMessageCoroutineExample :
MonoBehaviour
{
void Start()
{
Invoke("DelayedAction", 2.0f); // Using Invoke
StartCoroutine(WaitAndPerformAction(3.0f));
// Using Coroutine
}
void Update()
{
if (Input.GetKeyDown(KeyCode.Space))
{
SendMessage(„PerformAction");
// Using SendMessage
}
}
void DelayedAction()
{
Debug.Log("Action performed after delay.");
}
IEnumerator WaitAndPerformAction(float delay)
{
yield return new WaitForSeconds(delay); // Waiting
Debug.Log("Coroutine action performed
after delay.");
}
void PerformAction()
{
Debug.Log(„Action performed via SendMessage.");
}
}

using System.Collections.Generic;
using UnityEngine;

public class ObjectPool : MonoBehaviour
{
    public GameObject prefab;
    public int poolSize = 10;

    private List<GameObject> pooledObjects;

    private void Start()
    {
        pooledObjects = new List<GameObject>();

        for (int i = 0; i < poolSize; i++)
        {
            GameObject obj = Instantiate(prefab);
            obj.SetActive(false);
            pooledObjects.Add(obj);
        }
    }

    public GameObject GetPooledObject()
    {
        foreach (GameObject obj in pooledObjects)
        {
            if (!obj.activeInHierarchy)
            {
                obj.SetActive(true);
                return obj;
            }
        }

        return null;
    }
}

