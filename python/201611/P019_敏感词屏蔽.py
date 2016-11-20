import re
word_nums = int(raw_input())
words = []
for i in range(word_nums):
    words.append(raw_input().lower())
goals = raw_input()
goals_lowwer = goals.lower()
flags = [0 for i in range(len(goals_lowwer))]

for word in words:
    pos = [m.start() for m in re.finditer(word, goals_lowwer)]
    for s in pos :
        flags[s:s+len(word)] = [1] * len(word)

ans = []
for i in range(len(flags)):
    if flags[i] == 1:
        ans.append('*')
    else:
        ans.append(goals[i])

print(''.join(ans))
