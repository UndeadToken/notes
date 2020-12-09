package specs

import "fmt"

type Sword struct {
	name string
}

func (Sword) Damage() int {
	return 2
}

// Implements fmt.Stringer
func (s Sword) String() string {
	return fmt.Sprintf(
		"%s is a sword that can deal %d points of damage to oponents",
		s.name, s.Damage,
	)
}

type EnchantedSword struct {
	Sword
}

func (EnchantedSword) Damage() int {
	return 42
}
