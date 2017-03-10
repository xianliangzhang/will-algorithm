package top.kou.will.pattern;

/**
 * Created by Administrator on 2017/3/10.
 * 命令模式：发令官、传话筒、执行者三者分离
 */
public class CommandPattern {
    interface Command {
        void exec();
    }

    interface Receiver {
        void action();
    }


    static class RealCommand implements Command {
        private Receiver receiver;

        public RealCommand(Receiver receiver) {
            this.receiver = receiver;
        }

        @Override
        public void exec() {
            receiver.action();
        }
    }

    static class Invoker {
        private Command command;

        public void setCommand(Command command) {
            this.command = command;
        }

        public void execCommand() {
            command.exec();
        }
    }


    ////////////////////////////////////////
    //               帐户系统              //
    ///////////////////////////////////////

    static class Account {
        protected int balance;

        public int getBalance() {
            return balance;
        }

        protected void setBalance(int balance) {
            this.balance = balance;
        }
    }

    static abstract class MoneyInOutCommand implements Command {
        private Account account;

        public MoneyInOutCommand(Account account) {
            this.account = account;
        }

    }

    static class MoneyInCommand extends MoneyInOutCommand {
        public MoneyInCommand(Account account) {
            super(account);
        }

        @Override
        public void exec() {
        }
    }

}
