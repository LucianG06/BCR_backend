from twilio.rest import Client
import sys

account_sid = "ACd9e036318a11734d6241e9a91718bf73"
auth_token = "ee6439914af26eb4cd044c4d7a8dd6b1"
verify_sid = "VA1c1d488b64b47a48b3ff6bf29f2217d7"
verified_number = sys.argv[1]

client = Client(account_sid, auth_token)


cod_din_frontend = sys.argv[2]



verification_check = client.verify.v2.services(verify_sid) \
  .verification_checks \
  .create(to=verified_number, code=cod_din_frontend)
print(verification_check.status)


f = open("src//main//resources//static//code.txt", "w")
f.write(verification_check.status)
f.close()