import { UserRepositoryMock } from "../infrestructure/database/repositories/mocks/userRepositoryMock";
import { User } from "../domain/entities/User"
import { UserServices } from "../aplication/usecases/UserServices"

/** Approach: Inside-out
 * 1.- Age is created
 * 2.- Age under 13 cant be created -> throw Error
 * 3.- Age must be an integer. 
*/
describe('User services.', () => {

  test('User save', () => {
    const userRepositoryMocked = new UserRepositoryMock();
    const userToSave = User.createUser("Juan", 18, "juan@gmail.com")
    let saveSpy = jest.spyOn(userRepositoryMocked, 'save')
    UserServices.saveUser(userRepositoryMocked, userToSave)
    expect(saveSpy).toHaveBeenCalledWith(userToSave)
  });

  test('Get user from database.', () => {
    const userRepositoryMocked = new UserRepositoryMock();
    const userToGet = User.createUser("Juan", 18, "juan@gmail.com")
    const userResponse = UserServices.getUser(userRepositoryMocked, userToGet)
    expect(userToGet).toEqual(userResponse)
  });

})