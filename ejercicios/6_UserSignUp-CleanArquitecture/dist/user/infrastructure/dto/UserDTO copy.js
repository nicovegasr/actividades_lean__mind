"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.UserDTO = void 0;
const User_1 = require("../../domain/models/User");
class UserDTO {
    static createDomainUser(user) {
        return new User_1.User(user.getName(), user.getEmail(), user.getPassword(), user.getAge());
    }
}
exports.UserDTO = UserDTO;
