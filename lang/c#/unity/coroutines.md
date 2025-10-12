IEnumerator LoadAssetAsync(string assetName)
{
  ResourceRequest load =
    Resources.LoadAsync<GameObject>(assetName);
  
  while (!load.isDone)
  {
    yield return null; // Yield until the next frame
  }
  
  GameObject loadedAsset = load.asset as GameObject;
    // Additional logic to utilize the loaded asset
}

IEnumerator MoveObject(Vector3 start, Vector3 end, float duration)
{
  float elapsedTime = 0;

  while (elapsedTime < duration)
  {
    transform.position = Vector3.Lerp(start, end,(elapsedTime / duration));
    
    elapsedTime += Time.deltaTime;
    yield return null;
  }
  transform.position = end;
}

IEnumerator StartDelay(float delay)
{
  yield return new WaitForSeconds(delay);
  // Action to perform after the delay
  Debug.Log("Delay completed");
}

IEnumerator CheckGameState()
{
    while (true)
    {
        switch (currentState)
        {
            case GameState.Starting:
                // Initialize game start routines
                break;

            case GameState.Playing:
                // Handle gameplay logic
                break;

            case GameState.Ending:
                // Clean up after game end
                yield break; // Exit the coroutine
        }

        yield return null; // Wait for the next frame
    }
}

Coroutine myCoroutine;

void StartMyCoroutine()
{
    if (myCoroutine != null)
        StopCoroutine(myCoroutine);

    myCoroutine = StartCoroutine(MyCoroutineMethod());
}

void StopMyCoroutine()
{
    if (myCoroutine != null)
        StopCoroutine(myCoroutine);
}

//WaitForEndOfFrame
//WaitForFixedUpdate
IEnumerator WaitForThenAct()
{
    // Good for physics-related updates
    yield return new WaitForFixedUpdate();

    // Code here executes after all physics has been processed
}

