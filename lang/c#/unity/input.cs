using UnityEngine;
public class PlayerController : MonoBehaviour
{
public float speed = 5.0f;
void Update()
{
float moveHorizontal = Input.GetAxis("Horizontal");
Vector3 movement = new Vector3(moveHorizontal, 0.0f,
0.0f);
transform.position += movement * speed *
Time.deltaTime;
}
}

using UnityEngine;
public class PlayerMovement : MonoBehaviour
{
public float speed = 5.0f;
void Update()
{
float Horizontal = Input.GetAxis("Horizontal") *
speed * Time.deltaTime;
float vertical = Input.GetAxis("Vertical") * speed *
Time.deltaTime;
transform.Translate(horizontal, 0f, vertical);
}
}

if (Input.touchCount > 0) {
Touch touch = Input.GetTouch(0);
if (touch.phase == TouchPhase.Began) {
Vector3 touchPosition =
Camera.main.ScreenToWorldPoint(touch.position);
touchPosition.z = 0f;
// Ensure the object stays on the same plane
transform.position = touchPosition;
}
}

if (Input.GetMouseButton(0)) { // 0 is the left mouse button
Vector3 mousePosition =
Camera.main.ScreenToWorldPoint(Input.mousePosition);
mousePosition.z = 0f;
// Maintain object's position within the game plane
transform.position = mousePosition;
}


