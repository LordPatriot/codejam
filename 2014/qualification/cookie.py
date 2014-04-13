# Cookie CLicker Alpha
# https://code.google.com/codejam/contest/2974486/dashboard#s=p1

if __name__ == "__main__":
    inp = open("input.in")
    output = open("output.txt", 'w+')

    T = int(inp.readline())

    for i in range(0, T):
        source = inp.readline()
        sourceSeparated = source.split(" ")
        C = float(sourceSeparated[0])
        F = float(sourceSeparated[1])
        X = float(sourceSeparated[2])

        result = 0.0
        current_rate = 2.0

        while C/current_rate + X/(current_rate + F) < X/current_rate:
            result += C/current_rate
            current_rate += F

        result += X/current_rate

        output.write("Case #{0}: {1}\n".format(i + 1, result))

    inp.close()
    output.close()
