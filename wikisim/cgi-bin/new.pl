#!"C:\xampp\perl\bin\perl.exe"
use strict;
use warnings;
use CGI;
use CGI::Carp qw(fatalsToBrowser);
use DBI;

my $cgi = CGI->new;
print $cgi->header;

if ($cgi->request_method eq 'POST') {
    my $title = $cgi->param('title');
    my $content = $cgi->param('content');
    
    my $dbh = DBI->connect("dbi:SQLite:dbname=db/BaseDeDatos.db", "admin", "admin");
    my $sth = $dbh->prepare("INSERT INTO Articles (title, content) VALUES (?, ?)");
    $sth->execute($title, $content);

    $dbh->disconnect;

    print $cgi->redirect('/cgi-bin/list.pl');
} else {
    print $cgi->start_html('Nueva Página');
    print $cgi->start_form(-method => 'POST', -action => '/cgi-bin/new.pl');
    print $cgi->textfield(-name => 'title', -size => 50, -maxlength => 100);
    print $cgi->textarea(-name => 'content', -rows => 10, -cols => 50);
    print $cgi->submit('Crear Página');
    print $cgi->end_form;
    print $cgi->end_html;
}
