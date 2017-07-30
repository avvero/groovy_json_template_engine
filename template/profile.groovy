return [
        timestamp: new Date().time,

        id       : data.id,
        name     : data.name,
        created  : data.created,
        verified : data.verified,

        accounts: data.accounts.each {
            return [
                number: it.number
            ]
        }
]