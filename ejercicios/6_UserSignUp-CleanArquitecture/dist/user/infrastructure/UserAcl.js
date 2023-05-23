"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.UserAcl = void 0;
class UserAcl {
    constructor(name, email, password, age) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
    }
    createDomainModelFromRequest() {
    }
}
exports.UserAcl = UserAcl;
