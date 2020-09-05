import { User } from "\user.js";
function changeContent() {
    var num = Math.floor(Math.random() * (7 - 1 + 1)) + 1;
    switch (num) {
        case 1:
            return document.getElementById('para').innerHTML = "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Tenetur sint iste optio placeat dolor labore, reprehenderit ipsum aspernatur blanditiis maiores.";
            break;
        case 2:
            return document.getElementById('para').innerHTML = "Life is like a landscape. You live in the midst of it but can describe it only from the vantage point of distance.";
            break;
        case 3:
            return document.getElementById('para').innerHTML = "A critic is someone who never actually goes to the battle, yet who afterwards comes out shooting the wounded.";
            break;
        case 4:
            return document.getElementById('para').innerHTML = "God save me from my friends. I can protect myself from my enemies.";
            break;
        case 5:
            return document.getElementById('para').innerHTML = "Life is too short and sweet to be spent by cribbing and complaining about things. Here are some random quotes about the most wonderful gift that we've got";
            break;
        case 6:
            return document.getElementById('para').innerHTML = "Humor is richly rewarding to the person who employs it. It has some value in gaining and holding attention. But it has no persuasive value at all";
            break;
        case 7:
            return document.getElementById('para').innerHTML = "The price of anything is the amount of life you exchange for it.";
            break;
    }
}

let obj = {
    budget : 0,
    expense : 0,
    expenseAmount : 0,
    balance : 0
}
let userBudget = document.getElementById('budget-amount')
let userExpense = document.getElementById('expense')
let userExpenseAmount = document.getElementById('expense-amount')
function calc () {
    if (userBudget.value === '' || userBudget.value <= 0 ) {
        alert ('Your Budget not empty or negative number')
    } else {
        obj.budget = userBudget.value;
        document.getElementById('para-budget').innerHTML = obj.budget;
        obj.balance = obj.budget;
        document.getElementById('para-balance').innerHTML = obj.balance;
    }
}
function addExpense() {
    if ( userExpense.value === '' || userExpenseAmount.value === '' ) {
        alert ('your expense and expense amount not empty')
    } else if ( userExpenseAmount.value <= 0 ) {
        alert ('expense amount isn\'t negative number or 0')
    } else {
        obj.expense = userExpense.value;
        document.getElementById('expense-title').innerHTML = userExpense.value;
        obj.expenseAmount -= - userExpenseAmount.value;
        document.getElementById('expense-value').innerHTML = userExpenseAmount.value;
        document.getElementById('para-expenseAmount').innerHTML = obj.expenseAmount;
        obj.balance = obj.budget - obj.expenseAmount;
        document.getElementById('para-balance').innerHTML = obj.balance;
    } 
}

