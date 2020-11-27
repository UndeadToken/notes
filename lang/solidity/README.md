# Solidity
Solidity is an object-oriented, high-level language for implementing smart contracts. 

Every account has a balance in Ether (in “Wei” to be exact, 1 ether is 10**18 wei) which can be modified by sending transactions that include Ether.

### Language Constructs
- Pragmas are common instructions for compilers about how to treat the source code (e.g. pragma once).

- Require asserts that a condition is met. `require(foo === bar, "le false")` where the message can be omitted.

- Transfer ether `if (!msg.sender.send(amount)) { ...` `beneficiary.transfer(...`

### Types
- The address type is a 160-bit value that does not allow any arithmetic operations. It is suitable for storing addresses of contracts, or a hash of the public half of a keypair belonging to external accounts.

```
// SPDX-License-Identifier: GPL-3.0
pragma solidity ^0.7.0;
```
Addresses:
```
address public foo;
address payable public bar;
```
Hashmaps:
```
mapping(address => uint) public addresses;
uint storage reference = addresses[msg.sender];
```
Dynamic Arrays:
```
uint[] public things;
things.push(1);
```
Structs:
```
struct Foo {
    uint foo;
    bool bar;
    address fizz;
    uint buzz;
}
Foo({...})
```

### Modifiers
Modifiers are a convenient way to validate inputs to functions.
```
modifier onlyBefore(uint _time) { require(block timestamp < _time); _; }
```

### Enums
Defaults to first member.
```
enum State { Created, Locked, Release, Inactive }
State public state;

modifier condition(bool _condition) {
    require(_condition);
    _;
}
```

### Constructors
```
constructor(bytes32[] memory _foo) {
    foo = _foo
}
```

### Functions
```
function foo() public view 
    returns (address addr)
{
    foo_ = addresses[addr];
}
```
The keyword payable is required for the function to be able to receive Ether.
```
function bid() public payable { ...
```

### Events
```
event HighestBidIncreased(address bidder, uint amount);
emit HighestBidIncreased(msg.sender, msg.value);
```

### Install
Linux:
```
sudo add-apt-repository ppa:ethereum/ethereum
sudo apt-get update
sudo apt-get install solc
```
Mac:
```
brew update
brew upgrade
brew tap ethereum/ethereum
brew install solidity
```
Docker
```
docker run -v /local/path:/sources ethereum/solc:stable -o /sources/output --abi --bin /sources/Contract.sol
```

### References
https://solidity.readthedocs.io/
https://remix.ethereum.org/
https://github.com/ethereum/web3.js/
