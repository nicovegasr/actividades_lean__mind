import {Age} from "./Age";
/** Approach: Inside-out
 * 1.- Age is created
 * 2.- Age 0 doesn´t exist -> throw Error
 */
describe('Age test.', () => {

  test('Age is created.', () => {
    const myAge: Age = new Age(18);
    expect(myAge.age).toBe(18)
  });

})