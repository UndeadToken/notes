#include <sys/param.h>
#include <sys/module.h>
#include <sys/kernel.h>
#include <sys/systm.h>

/* The function called at load/unload. */
static int
load(struct module *module, int cmd, void *args)
{
	int error = 0;

	switch (cmd) {
	case MOD_LOAD:
		uprintf("Module loaded\n");
		break;

	case MOD_UNLOAD:
		uprintf("Module unloaded");
	
	default:
		error = EOPNOTSUPP;
		break;
	}

	return(error);
}

/* The second argument of DECLARE_MODULE. */
static moduledata_t test_mod = {
	"test", /* module name */
	load,   /* event handler */
	NULL    /* extra data */
};

DECLARE_MODULE(test, test_mod, SI_SUB_DRIVERS, SI_ORDER_MIDDLE);
