// structs, enums and unions

// Unit struct.

struct Dummy; // No size at runtime as there is no data associated with them.

// Tuple struct.

struct Color(u8, u8, u8);

// C-like struct.

struct Player {
	name: String,
	iq: u8,
	friends: u8,
	score: u16
}

// Enum.

enum Direction {
	N,
	E,
	S,
	W
}

enum PlayerAction {
	Move {
		direction: Direction,
		speed: u8
	},
	Wait,
	Attack(Direction)
}

fn main() {
	// Unit.
	let value = Dummy; 

	// Tuple.
	let white = Color(255, 255, 255);
	let red = white.0;
	let Color(r, g, b) = white; // Destructure.
	println!("R {}, G {}, B {}", r, g, b); // Ignore field with Color(g, _, b)

	// C-like.
	let name = "Jimmers".to_string();	
	let player = Player {
		name,
		iq: 8,
		friends: 0,
		score: 9000
	};
	player.score += 1;

	// Enum.
	let simulated_player_action = PlayerAction::Move {
		direction: Direction::N,
		speed: 2
	};
	match simulated_player_action {
		PlayerAction::Wait => println!("Player wants to wait.."),
		PlayerAction::Move { direction, speed } => {
			println!("Player wants to move in direction {:?} with speed {}", direction, speed);
		},
		PlayerAction::Attack(direction) => {
			println!("Player wants to attack direction {:?}", direction);
		}
	}
}

















