"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.UserRequest = void 0;
class UserRequest {
    constructor(name, email, password, age) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
    }
    static create(name, email, password, age) {
        UserRequest.validateName(name);
        UserRequest.validateEmail(email);
        UserRequest.validatePassword(password);
        UserRequest.validateAge(age);
        return new UserRequest(name, email, password, age);
    }
    static validateName(name) {
        if (name === undefined) {
            throw new Error("Name is empty");
        }
        if (name.length < 0) {
            throw new Error("Name is empty");
        }
    }
    static validateEmail(email) {
        const emailRegex = new RegExp("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$");
        if (email === undefined) {
            throw new Error("Email is empty");
        }
        if (email.length < 0) {
            throw new Error("Email is empty");
        }
        if (!emailRegex.test(email)) {
            throw new Error("Email is not valid");
        }
    }
    static validatePassword(password) {
        if (password === undefined) {
            throw new Error("Password is empty");
        }
        if (password.length < 0) {
            throw new Error("Password is empty");
        }
        if (password.length < 6) {
            throw new Error("Password is too short");
        }
    }
    static validateAge(age) {
        if (age === undefined) {
            throw new Error("Age is empty");
        }
        if (isNaN(age)) {
            throw new Error("Age is not an integer");
        }
        if (age < 0) {
            throw new Error("Age is empty");
        }
        if (age < 18) {
            throw new Error("Age is not valid");
        }
    }
}
exports.UserRequest = UserRequest;
