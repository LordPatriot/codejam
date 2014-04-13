# Deceitful war
# https://code.google.com/codejam/contest/2974486/dashboard#s=p3
# Alpha: one array for both Naomi's and Ken's bricks, O(N^2)


class Brick():
    def __init__(self, weight, is_naomi):
        self.weight = weight
        self.is_naomi = is_naomi

    def __gt__(self, other):
        return self.weight > other.weight

if __name__ == "__main__":
    inp = open("input.in")
    output = open("output.txt", 'w+')

    T = int(inp.readline())

    for i in range(0, T):
        N = int(inp.readline())

        source = inp.readline()
        sourceSeparated = source.split(" ")

        bricks = []
        for j in range(0, N):
            bricks.append(Brick(float(sourceSeparated[j]), True))

        source = inp.readline()
        sourceSeparated = source.split(" ")

        for j in range(0, N):
            bricks.append(Brick(float(sourceSeparated[j]), False))

        bricks.sort()

        bricks_round2 = list(bricks)

        #Deceitful war
        points_deceitful_war = 0

        while len(bricks) > 0:
            remove_naomi = -1
            remove_ken = -1

            temp_naomi = -1
            temp = len(bricks) - 1

            # here the match is performed in O(N)
            for j in range(0, len(bricks)):
                if bricks[len(bricks) - 1 - j].is_naomi:
                    temp_naomi = len(bricks) - 1 - j
                else:
                    if temp_naomi > -1:
                        remove_naomi = temp_naomi
                        remove_ken = len(bricks) - 1 - j
                        temp_naomi = -1

            if remove_ken > -1 and remove_naomi > -1:
                bricks.pop(remove_naomi)
                bricks.pop(remove_ken) #will work as ken's brick is smaller
                points_deceitful_war += 1

            else:
                remove_naomi = -1
                remove_ken = -1
                for j in range(0, len(bricks)):
                    if bricks[j].is_naomi and remove_naomi == -1:
                        remove_naomi = j
                    else:
                        remove_ken = j

                bricks.pop(remove_ken)
                bricks.pop(remove_naomi) #will work as naomi's brick is smaller

        #Fair war
        points_fair_war = 0

        while len(bricks_round2) > 0:
            current_naomi = -1
            remove_ken = -1

            for j in range(0, len(bricks_round2)):
                if current_naomi > -1:
                    break
                else:
                    if bricks_round2[j].is_naomi:
                        current_naomi = j

            for j in range(0, len(bricks_round2)):
                if remove_ken > -1:
                    break
                else:
                    if not bricks_round2[j].is_naomi and bricks_round2[j] > bricks_round2[current_naomi]:
                        remove_ken = j

            if remove_ken > -1:
                bricks_round2.pop(remove_ken)
                bricks_round2.pop(current_naomi)
            else:
                bricks_round2.pop(current_naomi)
                bricks_round2.pop(remove_ken)
                points_fair_war += 1

        output.write("Case #{0}: {1} {2}\n".format(i + 1, points_deceitful_war, points_fair_war))

    inp.close()
    output.close()

