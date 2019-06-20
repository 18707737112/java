package hw2;

public class Worker {
    private void prepareWork(){
        System.out.println("准备工作！");
    }
    private void startWork(){
        System.out.println("开始工作！");
    }
    private void finishWork(){
        System.out.println("结束工作！");
    }
    public void work(){
        prepareWork();
        startWork();
        finishWork();
    }
}
