# Scene Management

```
```
using UnityEngine;
using UnityEngine.SceneManagement;

public class SceneLoader : MonoBehaviour
{
  public void LoadGameLevel()
  {
    SceneManager.LoadScene("GameLevel");
  }
}
```
```


IEnumerator LoadYourAsyncScene(string sceneName)
{
  AsyncOperation asyncLoad = SceneManager.LoadSceneAsync(sceneName);
  
  // While the asynchronous operation to load the new
  // scene is not yet complete, continue waiting until
  // it's done.
  while (!asyncLoad.isDone)
  {
    // Here, you can also update the loading screen
    // progress bar or any loading indicators you have.
    yield return null;
  }
}

### Maintain game state between transitions.

public class GameManager : MonoBehaviour
{
  public static GameManager Instance;
  
  void Awake()
  {
    if (Instance == null)
    {
      Instance = this;
      DontDestroyOnLoad(gameObject);
    }
    else if (Instance != this)
    {
      Destroy(gameObject);
    }
}


