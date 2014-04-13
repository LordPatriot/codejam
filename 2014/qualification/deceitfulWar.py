# Deceitful war
# https://code.google.com/codejam/contest/2974486/dashboard#s=p3
# Beta: two separate arrays, O(N^3)

if __name__ == "__main__":
    inp = open("input.in")
    output = open("output.txt", 'w+')

    T = int(inp.readline())

    for i in range(0, T):
        N = int(inp.readline())

        source = inp.readline()
        sourceSeparated = source.split(" ")

        naomi_round1 = []
        for j in range(0, N):
            naomi_round1.append(float(sourceSeparated[j]))

        source = inp.readline()
        sourceSeparated = source.split(" ")

        ken_round1 = []
        for j in range(0, N):
            ken_round1.append(float(sourceSeparated[j]))

        naomi_round1.sort()
        ken_round1.sort()

        ken_round2 = list(ken_round1)
        naomi_round2 = list(naomi_round1)

        #Deceitful war
        points_deceitful_war = 0

        while len(naomi_round1) > 0:
            point_scored = False
            remove_naomi = -1
            remove_ken = -1

            # here the match is performed in O(N^2)
            for j in range(0, len(naomi_round1)):
                for k in range(0, len(ken_round1)):
                    if naomi_round1[j] > ken_round1[k] and not point_scored:
                        remove_naomi = j
                        remove_ken = k
                        points_deceitful_war += 1
                        point_scored = True

            if not point_scored:
                naomi_round1.pop(0)
                ken_round1.pop()
            else:
                naomi_round1.pop(remove_naomi)
                ken_round1.pop(remove_ken)

        #Fair war
        points_fair_war = 0

        while len(naomi_round2) > 0:
            current_naomi = naomi_round2[0]
            remove_ken = -1

            for j in range(0, len(ken_round2)):
                if ken_round2[j] > current_naomi and remove_ken == -1:
                    remove_ken = j

            if remove_ken > -1:
                naomi_round2.pop(0)
                ken_round2.pop(remove_ken)
            else:
                naomi_round2.pop(0)
                ken_round2.pop(0)
                points_fair_war += 1

        output.write("Case #{0}: {1} {2}\n".format(i + 1, points_deceitful_war, points_fair_war))

    inp.close()
    output.close()

