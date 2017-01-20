public class Solution {
    /** Yunqiu Xu*/
    /** Method: Stack 
     * 1. 等于“/”，跳过，直接开始寻找下一个element
     * 2. 等于“.”，什么都不需要干，直接开始寻找下一个element
     * 3. 等于“..”，弹出栈顶元素，寻找下一个element
     * 4. 等于其他，插入当前element为新的栈顶，寻找下一个element
     * 
     * Different cases:
     * "/a/./b/../../c/" --> "/c"
     * "/a/./b/../c/" --> "/a/c"
     * "/a/./b/c/", => "/a/b/c"
     * "/home/" --> "/home"
     * "/../" --> "/"
     * "/home//foo/" --> "/home/foo"
     */
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] paths = path.split("/");
        for (String subpath : paths) {
            if (!stack.isEmpty() && subpath.equals("..")) { //case 3
                stack.pop();
            } 
            else if (!subpath.equals(".") && !subpath.equals("") && !subpath.equals("..")) { //case 4
                stack.push(subpath);
            }
            else{
                continue; //case 1 / case 2
            }
        }
        List<String> list = new ArrayList(stack);
        return "/" + String.join("/", list);
    }
}
