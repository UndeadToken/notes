# Linux

Linux based operating systems.

### Acronyms

|Acronyms|Description|
|-|-|
|UNIX| Uniplexed Information and Computing Service|
|BSD| berkely software distribution|
|posix| portable operating system interface|
|SVID| System V Interface Definition|
|USL| Unix System Laboratories|
|fsf| free software foundation|
|gnu| Gnu's Not Unix|
|OSI| Open Source Initiative (opensource.org)|
|BSD| License: berkley Software Distribution license|
|LGPL| The GNU lesser general public license|
|GPL| GNU public license|
|rhel| Redhat enterprise linux|
|rhce| Red hat certified engineer|
|rhcsa| red hat certified systems administrator|

### Drivers

|Driver|Description|
|-|-|
|lscpi|lists PCI drivers|
|lsusb|list usb drivers|
|lspcmcia|lists pcmcia cards (apt-install pcmiautils)|
|lsdev|lists communication resources|
|lshw|long description of hardware discovered as well as above...|
|dmesg|review kernel logs|
|free, df -h|memory|
|kill|kill process|
|bg|send process to background|
|fg|bring process to foreground|
|jobs|show background processes|


### Shell Environment Variables

|Name|About|
|-------|----|
|BASH|Contains the full pathname of the bash command|
|BASH_VERSION|A number representing the current version of the bash command|
|EUID|The effective user ID number of the current user|
|FCEDIT|The text editor used by the fc command|
|HISTFILE|The location of the history file|
|HISTCMD|The number of the current command in the history list|
|HOME|The home diretcory|
|HOSTTYPE|The computer architecture|
|MAIL|The location of the mailbox|
|OLDPWD|The previous directory|
|OSTYPE|The operating system|
|PATH|Comma separated list of paths to locate commands|
|PPID|The process id of the command that started the current shell|
|PROMPT_COMMAND|A command run before each shell|
|PS1,PS2,PS3,...|Shell prompts|
|RAND|A number 0-99999|
|SECONDS|The number of seconds since the shellw as started|
|SHLVL|The number of shell levels associated with the current shell|
|TMOUT|The amount of time the shell can remain idle|

### Special Characters (e.g. add to bash prompt)

|Character|Description|
|-|-|
|\!|The current command history number|
|\#|This shows the command number of the curent command|
|\$|Shows the user prompt($) or the root prompt(#)|
|\W|The current directory base name|
|\[|Precedes a sequence of non-printable characters|
|\]|Follows a sequence of non-printable characters|
|\\|A backslash|
|\d|The day name, month and day number of the current date|
|\h|The hostname|
|\n|A newline|
|\nnn|The character that relates to the octal number replacing nnn|
|\s|The current shell name|
|\t|The current time in hours, minutes and seconds|
|\u|The current username|
|\w|Full path of the current directory|

### Permissions

```bash
read = 4
write = 2
execute = 1

rwx = 4 + 2 + 1 = 7

_ _ _ = user, group, other = ugo
e.g. chmod 754 rwx for user, rx for group and r for other.
e.g. chmod -R a+x will recursively add user executable rights.
```

### Logging
For systems that don't use systemd, rsyslogd is the main utility for logging error and debugging messages, although some older systems still use syslogd. You can still use rsyslogd with systemd.

```bash
# systemd uses journalctl for gathering and collecting data.
journalctl --list-boots | head

-b # messages associated with a specific boot instance
-k # show only kernel messages
-a # show all fields
-f # follow messages as they come in

journalctl _SYSTEMD_UNIT=sshd.service # specific servics
journalctl PRIORITY=0 # limit by syslog level e.g. 0 being emergency
journalctl -a -f # follow messages as they come in, show all fields

# rsyslog
/etc/rsyslog.conf
boot.log
messages, security

```

### Metacharacters

```bash
* - match any characters
? - match any one character
[..] - match anything bwteen the brackets
[a-z] - range

e.g.

ls a*
ls a*c
ls ?????e*
ls [abc]*[as]

file redirection:

< - directs the contents of a file to the command.
> - directs the standard output of a command to a file.
2> - directs standard error (error messages) toa  file.
&> - directs both standard output & standard error to a file.
>> - Directs output of a command to a file, adding the output to the end of an exisiting file.
<< - standard input

brace expansions:
touch memo{1,2,3,4,5}
touch {john,Bill,Sally}-{Breakfast,Lunch,Dinner}
touch {a..f}{1..5}

```

### Bash config files
```
/etc/profile
/etc/bashrc
~/bash_profile
~/.bashrc
~/.bash_logout
```

### Resources

distrowatch.com
slackware.com
redhat.com/certification
