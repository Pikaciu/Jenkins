// email Notification
def EmailNoti(String stage, String appName, String email_recipient, String version){
    return{
        emailext(subject: """${stage} Status [Started] - Application: ${appName} ${version} [Staging] BUILD : ${env.BUILD_NUMBER}""", mimeType: 'text/html', body: """
        <html>
        <head>
        <style>
        a.button {
            border: none;
            color: white;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;
        }
     
        a.button1 {background-color: #4CAF50;} /* Green */
        a:hover {background-color: grey;}
     
     
        </style>
        </head>
        <body>
     
        <h2>Deploying Application: ${appName} [Staging] BUILD : ${env.BUILD_NUMBER} </h2>
        <h2>To monitor ${stage}, please click Jenkins Dashboard button below.</h2>
     
        <a href=${env.JENKINS_URL}blue/organizations/jenkins/${env.JOB_NAME}/detail/${env.JOB_NAME}/${env.BUILD_NUMBER}/pipeline class="button button1">Jenkins Dashboard</a>
     
     
        </body>
        </html>""", to: """${email_recipient}""")
    }
}
