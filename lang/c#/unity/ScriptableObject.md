# ScriptableObject

using UnityEngine;
using System.Collections.Generic;
[CreateAssetMenu(fileName = "New Inventory", menuName = "Inventory
System/Inventory")]
public class Quests : ScriptableObject
{
public List<Quest> completedQuests = new List<Quest>();
public void AddItem(Item itemToAdd)
{
// Add quests to the list
}
}
