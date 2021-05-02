import math


def mean(*args):
	val_sum = sum(args)
	return val_sum / len(args)

def median(*args):
	if len(args) % 2 == 0:
		i = round((len(args) + 1) / 2)
		j = i - 1
		return (args[i] + args[j] / 2)
	else:
		k = round(len(args) / 2)
		return args[k]

def mode(*args):
	dict_vals = {i: args.count(i) for i in args}
	max_list = [k for k,v in dict_vals.items() if v == max(dict_vals.values())]
	return max_list

def variance(*args):
	mean_val = mean(*args)
	numerator = 0
	for i in args:
		numerator += (i - mean_val) ** 2
	denominator = len(args) - 1
	return numerator / denominator

def standard_deviation(*args):
	return math.sqrt(variance(*args))

def coefficient_variation(*args):
	return standard_deviation(*args) / mean(*args)

def covariance(*args):
	list_1 = [i[0] for i in args]
	list_2 = [i[1] for i in args]
	list_1_mean = mean(*list_1[0])
	list_2_mean = mean(*list_2[0])
	numerator = 0
	if len(list_1) == len(list_2):
		for i in range(len(list_1)):
			numerator += (list_1[0][i] - list_1_mean) * (list_2[0][i] - list_2_mean)
		denominator = len(list_1[0]) - 1
		return numerator / denominator
	return None

def correlation_coefficient(*args):
	list_1 = [i[0] for i in args]
	list_2 = [i[1] for i in args]
	list_1_sd = standard_deviation(*list_1[0])
	list_2_sd = standard_deviation(*list_2[0])
	denominator = list_1_sd * list_2_sd
	numerator = covariance(*args)
	return numerator / denominator
