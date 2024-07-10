#!"C:\xampp\perl\bin\perl.exe"
use strict;
use warnings;
use CGI;
use CGI::Carp qw(fatalsToBrowser);
use DBI;

my $cgi = CGI->new;
print $cgi->header;

my $id = $cgi->param('id');

if ($cgi->request_method eq 'POST') {
    my $content = $cgi->param('content');
    
    my $dbh = DBI->connect("DBI:mysql:database=BaseDeDatos;host=localhost", "admin", "admin", {RaiseError => 1, PrintError => 0});
    my $sth = $dbh->prepare("UPDATE Articles SET content = ? WHERE id = ?");
    $sth->execute($content, $id);

    $dbh->disconnect;

    print $cgi->redirect('../cgi-bin/view.pl?id=' . $id);
} else {
    my $dbh = DBI->connect("DBI:mysql:database=BaseDeDatos;host=localhost", "admin", "admin", {RaiseError => 1, PrintError => 0});
    my $sth = $dbh->prepare("SELECT title, content FROM Articles WHERE id = ?");
    $sth->execute($id);

    if (my @row = $sth->fetchrow_array) {
        my ($title, $content) = @row;
        print $cgi->start_html('Editar Página');
        print $cgi->h1('Editar Página');
        print $cgi->start_form(-method => 'POST', -action => '../cgi-bin/edit.pl?id=' . $id);
        print $cgi->textarea(-name => 'content', -rows => 10, -cols => 50, -default => $content);
        print $cgi->submit('Guardar Cambios');
        print $cgi->end_form;
        print $cgi->a({-href => '../cgi-bin/list.pl'}, 'Volver al Listado');
        print $cgi->end_html;
    } else {
        print $cgi->start_html('Error');
        print $cgi->h1('Error');
        print $cgi->p('Página no encontrada.');
        print $cgi->a({-href => '../cgi-bin/list.pl'}, 'Volver al Listado');
        print $cgi->end_html;
    }

    $dbh->disconnect;
}