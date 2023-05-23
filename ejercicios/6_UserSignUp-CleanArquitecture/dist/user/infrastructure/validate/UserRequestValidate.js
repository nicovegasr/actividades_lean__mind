"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.UserRequestValidate = void 0;
class UserRequestValidate {
    constructor(name, email, password, age) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
    }
    static create(name, email, password, age) {
        UserRequestValidate.validateName(name);
        UserRequestValidate.validateEmail(email);
        UserRequestValidate.validatePassword(password);
        UserRequestValidate.validateAge(age);
        return new UserRequestValidate(name, email, password, age);
    }
    static validateName(name) {
        if (name === undefined) {
            throw new Error("User name is undefined.");
        }
        if (name.length === 0) {
            throw new Error("User name is empty.");
        }
    }
    static validateEmail(email) {
        const emailRegex = new RegExp("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.([a-zA-Z]{2,4})+$");
        if (email === undefined) {
            throw new Error("User email is undefined.");
        }
        if (email.length === 0) {
            throw new Error("User email is empty.");
        }
        if (!emailRegex.test(email)) {
            throw new Error("User email is invalid.");
        }
    }
    static validatePassword(password) {
        if (password === undefined) {
            throw new Error("User password is undefined.");
        }
        if (password.length === 0) {
            throw new Error("User password is empty.");
        }
        if (password.length < 6) {
            throw new Error("User password is less than 6 characters.");
        }
    }
    static validateAge(age) {
        if (age === undefined) {
            throw new Error("User age is undefined.");
        }
        if (age < 18) {
            throw new Error("User age is less than 18.");
        }
        if (Number.isInteger(age) === false) {
            throw new Error("User age is not a number.");
        }
    }
    getName() {
        return this.name;
    }
    getEmail() {
        return this.email;
    }
    getPassword() {
        return this.password;
    }
    getAge() {
        return this.age;
    }
}
exports.UserRequestValidate = UserRequestValidate;
