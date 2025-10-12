# Lighting

using UnityEngine;

public class DayNightCycle : MonoBehaviour
{
  public Light directionalLight;
  public float dayLength;
  private float timeCounter = 0;

  void Update()
  {
    timeCounter += Time.deltaTime / dayLength;
    // Change light intensity and color based on
    timeCounter directionalLight.intensity = Mathf.Lerp(0.1f, 1f,
      Mathf.Abs(Mathf.Cos(timeCounter * Mathf.PI * 2f)));
    
    directionalLight.color = Color.Lerp(new Color(0.3f, 0.4f, 0.6f), Color.white,  directionalLight.intensity);

  }
}

using UnityEngine;
public class TerrainDeformer : MonoBehaviour
{
public Terrain terrain;
private TerrainData terrainData;
private float[,] originalHeightMap;
void Start()
{
terrainData = terrain.terrainData;
originalHeightMap = terrainData.GetHeights(0, 0,
terrainData.heightmapResolution,
terrainData.heightmapResolution);
}

void Update()
{
Vector3 playerPosition = transform.position;
Vector3Int terrainPosition = new Vector3Int(
Mathf.RoundToInt(playerPosition.x),
Mathf.RoundToInt(playerPosition.y),
Mathf.RoundToInt(playerPosition.z)
);
// Deform terrain under player
// Note: This is a simplified example. In practice,
// you'll need to convert the player's position to
// terrain's local space and modify a range of
// heights around the player.
terrainData.SetHeights(terrainPosition.x,
terrainPosition.z,
new float[,] { { 0.5f } });
}

void OnDestroy()
{
// Restore the original terrain heights when the
// script is destroyed
terrainData.SetHeights(0, 0, originalHeightMap);
}
}

•
Occlusion culling: Occlusion culling enhances performance by not rendering objects hidden
from the camera, significantly reducing draw calls and boosting frame rates. Unity’s built-in
system allows developers to configure occlusion culling in the project settings, tailoring it to
suit their game’s needs.
•
LOD settings: LOD reduces 3D model complexity based on distance from the camera, lightening
the processing load while maintaining visual quality. In Unity, LOD groups automate model
switching to optimize performance without compromising aesthetics.
•
Using static and dynamic game objects: Understanding when to use static versus dynamic
objects is crucial for optimization. Static objects such as buildings, trees, and street furniture,
which do not move or change during gameplay, can be batched by Unity to reduce draw calls,
enhancing performance. Conversely, dynamic objects such as characters, vehicles, and animated
props, which are subject to change, are treated differently by the engine. Strategically marking
objects as static in the Unity Editor can lead to significant performance gains, especially in
scenes with a high number of stationary elements. Note that this setting is frequently found in
a game object’s Inspector window.


