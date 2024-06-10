
struct BitFlags {
	flags: u8
}

impl BitFlags {
	fn new() -> BitFlags {
		BitFlags {
			flags: 0
		}
	}

	fn xor(&mut self, flag: u8) {
		self.flags ^= flag;
	}
}

const A_POWERUP: u8 = 1;
const B_POWERUP: u8 = 2;
const C_POWERUP: u8 = 4;

struct Player {
	powerups: BitFlags
}

impl Player {
	fn new() -> Player {
		Player {
			powerups: BitFlags::new()
		}
	}

	fn powerup(&mut self, powerup: u8) {
		self.powerups.xor(powerup);
	}
}

fn main() {
	let mut player = Player::new();
	player.powerup(B_POWERUP);
	player.print();
}
