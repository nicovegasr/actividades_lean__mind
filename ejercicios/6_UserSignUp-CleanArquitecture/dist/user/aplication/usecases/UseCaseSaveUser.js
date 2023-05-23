"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.UseCaseSaveUser = void 0;
const UseCaseSaveUser = async (user, userRepository) => {
    const userExists = await userRepository.userExists(user.getEmail());
    if (userExists) {
        throw new Error("User already exists.");
    }
    await userRepository.save(user);
};
exports.UseCaseSaveUser = UseCaseSaveUser;
