import sys

member_list = sys.stdin.readlines()[1:]
member_list.sort(key=lambda member: int(member.split()[0]))

print("".join(member_list))
