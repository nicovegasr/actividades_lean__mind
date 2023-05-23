"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const UserRequest_1 = require("../../../../user/infrastructure/validate/UserRequest");
describe("User ACL tests to validate requests", () => {
    it("should validate user fields and create domain model", () => {
        const userRequest = UserRequest_1.UserRequest.create("prueba", "prueba@gmail.com", "prueba", 18);
        expect(userRequest).toBeInstanceOf(UserRequest_1.UserRequest);
    });
});
