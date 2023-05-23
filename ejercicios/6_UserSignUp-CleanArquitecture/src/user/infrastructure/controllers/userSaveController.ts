import { UseCaseSaveUser } from "../../aplication/usecases/UseCaseSaveUser";
import { UserRepository } from "../../domain/interfaces/UserRepository";
import { UserDTO } from "../dto/UserDTO";
import { UserRepositoryMongoAdapter } from "../repositories/UserRepositoryMongoAdapter";
import { UserRequestValidate } from "../validate/UserRequestValidate";
import * as express from "express";

export const userRoute = express.Router();

export const userSaveController = async (req: any, res: any) => {
  try {
    const userValidated: UserRequestValidate = UserRequestValidate.create(req.body.name, req.body.email, req.body.password, req.body.age);
    const userRepository: UserRepository = new UserRepositoryMongoAdapter();
    const user = UserDTO.createDomainUser(userValidated);
    await UseCaseSaveUser(user, userRepository);
    res.status(200).json({user: user});
  } catch (error: any) {
    res.status(400).json({message: error.message});
  }
}

userRoute.post("/save_user", userSaveController);