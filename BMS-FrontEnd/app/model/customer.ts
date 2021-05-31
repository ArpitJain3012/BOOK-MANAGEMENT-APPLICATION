import { Address } from "./address";

export interface Customer {
  customerId: number;
  email: string;
  fullName: string;
  password: string;
  mobileNumber: number;
  registerOn: Date;
  am: Address;
}
