from queue import Queue

ice_creams = ['C','M','S','V','Y']
preferences = ["CS","SV"]
#preferences = ["SV","VS","SV","VS"]
#preferences = ["CM","MS","SC"]




def bfs():

    q = Queue()
    q.put('')


    while not q.empty():

        current = q.get(0)

        current_ice_list = []
        for i in range(len(current)-1):
            current_ice_list.append(current[i]+current[i+1])

        if len(current) >= 2:
            current_ice_list.append(current[-1]+current[-1])


        if len(current_ice_list) > 0:
            # 사람 수만큼 생성
            ok_count = [0]*len(preferences)
            for person_idx, person in enumerate(preferences):
                person_pre = list(person)

                count = [0,0]
                for ice_layer in current_ice_list:
                    ice_layer = list(ice_layer)

                    if ice_layer[0] not in person_pre:
                        continue
                    if ice_layer[1] not in person_pre:
                        continue

                    if person_pre[0] in ice_layer[0]:
                        count[0] = 1

                    if person_pre[1] in ice_layer[0]:
                        count[1] = 1

                if count[0] + count[1] == 2:
                    ok_count[person_idx] = 1

            if sum(ok_count) >= len(preferences):
                return current

        for ice_type in ice_creams:
            new_ice = current + ice_type
            q.put(new_ice)


if __name__ =='__main__':
    print(bfs())