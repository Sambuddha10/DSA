class Solution:
    def maxSumOfSquares(self, num: int, sum: int) -> str:
        if sum > 9 * num:
            return ""

        q, r = divmod(sum, 9)

        if r == 0:
            return "9" * q + "0" * (num - q)

        return "9" * q + str(r) + "0" * (num - q - 1)