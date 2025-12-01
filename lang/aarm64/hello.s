    /* very small Linux aarch64 (arm64) program — write "Hello, world\n" and exit */
    .section .data
msg:
    .ascii "Hello, world\n"

    .section .text
    .global _start
_start:
    /* syscall: write(1, msg, 13) */
    mov     x0, #1            /* fd = 1 (stdout) */
    ldr     x1, =msg          /* pointer to msg */
    mov     x2, #13           /* length */
    mov     x8, #64           /* syscall number: sys_write (aarch64) */
    svc     #0

    /* syscall: exit(0) */
    mov     x0, #0            /* exit code 0 */
    mov     x8, #93           /* syscall number: sys_exit (aarch64) */
    svc     #0
