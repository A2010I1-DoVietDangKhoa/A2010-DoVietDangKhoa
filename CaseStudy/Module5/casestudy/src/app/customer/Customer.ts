import {CustomerType} from "./CustomerType";

export interface Customer {
  id: string;
  name: string;
  gender: number;
  personalId: string;
  email: string;
  phone: string;
  address: string;
  dateOfBirth: string;
  customerType: CustomerType;
}
