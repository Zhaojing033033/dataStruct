package com.leete.code.p0071;
import java.util.*;

/**
 * 题目
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径

 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。

  

 示例 1：

 输入："/home/"
 输出："/home"
 解释：注意，最后一个目录名后面没有斜杠。
 示例 2：

 输入："/../"
 输出："/"
 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
 示例 3：

 输入："/home//foo/"
 输出："/home/foo"
 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 示例 4：

 输入："/a/./b/../../c/"
 输出："/c"
 示例 5：

 输入："/a/../../b/../c//.//"
 输出："/c"
 示例 6：

 输入："/a//b////c/d//././/.."
 输出："/a/b/c"
 */

/**
 * 思路
 */

/**
 * 体会：
 *
 */
public class Solution {
    public static void main(String[] args) {
        String s = new Solution().simplifyPath1("/home//foo/");
        System.out.println(s);
    }

    /**
     * 这里将元素全部压入了栈中，取出来才进行了判断
     * 考虑 压入栈中时，就进行判断。简化代码
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> queue = new Stack<>();
        queue.addAll(Arrays.asList(split));
        List<String> reList=new LinkedList<>();
        int flag=0;
        while (!queue.empty()){
            String pop = queue.pop();
            if("..".equals(pop)){
                flag++;
            }else if(".".equals(pop)){

            }else if(!"".equals(pop)){
                if(flag>0){
                    flag--;
                }else{
                    reList.add(0,pop);
                }
            }
        }
        String join = "/"+String.join("/", reList);
        return join;
    }

    /**
     * 压入栈中时，就进行判断
     * @param path
     * @return
     */
    public String simplifyPath1(String path) {

        Deque<String> stack = new LinkedList<>();
        for (String s : path.split("/")) {
            if("..".equals(s))
                stack.pop();
            else if(!(s.equals(".") || s.equals(""))){
                stack.push(s);
            }
        }
        String res = "";
        for (String d : stack) res = "/" + d + res;
        return res.isEmpty() ? "/" : res;
    }
}
