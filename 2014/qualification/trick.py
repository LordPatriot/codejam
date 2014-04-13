# Magic Trick
# https://code.google.com/codejam/contest/2974486/dashboard#s=p0

if __name__ == "__main__":
    inp = open("input.in")
    output = open("output.txt", 'w+')

    T = int(inp.readline())

    for i in range(0, T):
        answer1 = int(inp.readline())

        grid1 = []
        for j in range(0, 4):
            source = inp.readline()
            sourceSeparated = source.split(" ")

            if answer1 - 1 == j:
                for k in range(0, 4):
                    grid1.append(int(sourceSeparated[k]))

        answer2 = int(inp.readline())

        grid2 = []
        for j in range(0, 4):
            source = inp.readline()
            sourceSeparated = source.split(" ")

            if answer2 - 1 == j:
                for k in range(0, 4):
                    grid2.append(int(sourceSeparated[k]))

        result = 0
        chosen = 0

        for j in range(0, 4):
            for k in range(0, 4):
                if grid1[j] == grid2[k]:
                    result += 1
                    chosen = grid1[j]

        if result == 0:
            output.write("Case #{0}: Volunteer cheated!\n".format(i + 1))
        elif result > 1:
            output.write("Case #{0}: Bad magician!\n".format(i + 1))
        else:
            output.write("Case #{0}: {1}\n".format(i + 1, chosen))

    inp.close()
    output.close()