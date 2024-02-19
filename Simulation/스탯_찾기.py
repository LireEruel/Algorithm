def find_worng_stats(n: int, stats: []):
    sum_stats = 0
    for i in range(n):
        if (i + 1) % 2 == 0:
            sum_stats -= stats[i]
        else:
            sum_stats += stats[i]

    result = -1
    result_is_odd = sum_stats > 0
    is_odd = True
    for i in range(n):
        print(result_is_odd and is_odd and sum_stats - stats[i] == 0)
        print(not result_is_odd and not is_odd and sum_stats + stats[i] == 0)
        if result_is_odd and is_odd and sum_stats - stats[i] == 0:
            result = i + 1
            break
        elif not result_is_odd and not is_odd and sum_stats + stats[i] == 0:
            result = i + 1
            break
        is_odd = not is_odd

    print(result)


find_worng_stats(4, [2, 5, 3, 1])
