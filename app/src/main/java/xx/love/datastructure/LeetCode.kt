package xx.love.datastructure

/**
 * @author : zhijun.li on 2019/1/15
 *   email : zhijun.li@timanetworks.com
 *
 */
//两数之和
class TwoSum {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for (i in 0 until nums.size) {
            for (j in (i + 1) until nums.size) {
                return intArrayOf(i, j)
            }
        }


        throw  IllegalArgumentException("No two sum solution")
    }

    fun twoSum2(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for (i in 0 until nums.size) {
            map[nums[i]] = i
        }
        for (i in 0 until nums.size) {
            val i1 = target - nums[i]
            if (map.containsKey(i1) && map[i1] != i) {
                return intArrayOf(i, map.get(i1)!!)
            }
        }
        throw IllegalArgumentException("No two sum solution")
    }

    fun twoSum3(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for (i in 0 until nums.size) {
            val i1 = target - nums[i]
            if (map.containsKey(i1)) {
                return intArrayOf(map.get(i1)!!, i)
            }
            map.put(nums[i], i)
        }
        throw IllegalArgumentException("No two sum solution")
    }
}

//两数相加
class twoNumbers {
    class Node(value: Int) {
        val value = value
        var next: Node? = null
    }

    fun addTwoNumbers(l1: Node, l2: Node): Node? {
        val dummyHead = Node(0)
        var p: Node? = l1
        var q: Node? = l2
        var curr = dummyHead

        var carry: Int = 0

        while (p != null || q != null) {
            val x = if (p != null) p.value else 0
            val y = if (q != null) q.value else 0
            val sum = carry + x + y
            carry = sum / 10
            curr.next = Node(sum % 10)
            curr = curr.next!!
            if (p != null) p = p.next
            if (q != null) q = q.next
        }
        if (carry > 0) {
            curr.next = Node(carry)
        }
        return dummyHead.next
    }

    fun addClockwise(l1: Node,l2:Node) : Node?{



        return null
    }
}