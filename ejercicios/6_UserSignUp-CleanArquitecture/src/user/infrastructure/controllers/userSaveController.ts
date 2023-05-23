import { UserDTO } from "../dto/UserDTO";
import { UserRepositoryMongoAdapter } from "../repositories/UserRepositoryMongoAdapter";
import { UserRequestValidate } from "../validate/UserRequestValidate";
import * as express from "express";

export const userRoute = express.Router();

export const userSaveController = async (req: any, res: any) => {
  try {
    const userValidated: UserRequestValidate = UserRequestValidate.create(req.body.name, req.body.email, req.body.password, req.body.age);
    const userRepository = new UserRepositoryMongoAdapter();
    const user = UserDTO.createDomainUser(userValidated);
    const userExists = await userRepository.userExists(user.getEmail());
    if (userExists) {
      throw new Error("User already exists.");
    }
    await userRepository.save(user);
    res.status(200).json({user: user});
  } catch (error: any) {
    res.status(400).json({message: error.message});
  }
}

userRoute.post("/save_user", userSaveController);