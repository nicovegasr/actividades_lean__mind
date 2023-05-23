"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const User_1 = require("../../domain/models/User");
const UserRequestValidate_1 = require("../validate/UserRequestValidate");
const UserDTO_1 = require("./UserDTO");
describe("User DTO", () => {
    it("should create the domain user from DTO.", () => {
        const userRequestValidate = UserRequestValidate_1.UserRequestValidate.create("prueba", "prueba@gmail.com", "prueba", 18);
        const user = UserDTO_1.UserDTO.createDomainUser(userRequestValidate);
        expect(user).toBeInstanceOf(User_1.User);
    });
});
