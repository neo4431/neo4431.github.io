export default class User {
    constructor (name, age, address, dateOfBirth, money) {
        this.userName = name;
        this.userAge = age;
        this.userAddress = address;
        this.userDateOfBirth = dateOfBirth;
        this.userMoney = money;
    }
    hello() {
        console.log('Hello ' + this.userName);
    }
    balance() {
        console.log(this.userMoney);
    }
    addMoney(value) {
        return this.userMoney += value;
    }
}
    myUser = new User('hieu', 16, 'Ha Noi', '12/03/20', 1000);
    myUser.hello();
    myUser.balance();
    myUser.addMoney(2000);