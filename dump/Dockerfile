FROM mongo

COPY ./nodes.json /nodes.json
CMD mongoimport --host mongodb -d range_problem -c node --type json --file /nodes.json --jsonArray